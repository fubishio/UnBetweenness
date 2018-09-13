import sys

def main(argv):
    if len(argv) != 2:
        print("Usage: python output_validator.py [path_to_input_file] [path_to_output_file]")
        return
    constraints_satisfied, num_constraints, constraints_failed = processInput(argv[0], argv[1])
    print("Satisfied {}/{} constraints. List of failed constraints: {}".format(constraints_satisfied, num_constraints, constraints_failed))

def processInput(input_file, output_file):
    fin = open(input_file, "r")
    fout = open(output_file, "r")

    num_person_in_input = int(fin.readline().split()[0])
    input_people_set = set(fin.readline().split())
    num_constraints = int(fin.readline().split()[0])

    output_ordering = fout.readline().split()
    output_ordering_set = set(output_ordering)
    output_ordering_map = {k: v for v, k in enumerate(output_ordering)}

    # input and output has nonmatching unique people
    if (len(output_ordering_set) != num_person_in_input):
        return "Input file has unique {} people, but output file has {}".format(num_person_in_input, len(output_ordering_set))
    # repeated people
    if (len(output_ordering_set) != len(output_ordering)):
        return "The output ordering contains repeated people."
    # not the same people
    if (input_people_set != output_ordering_set):
        return "The output ordering contains people that are different from the ones in the input ordering."

    # Counts how many constraints are satisfied.
    constraints_satisfied = 0
    constraints_failed = []
    for i in range(num_constraints):
        line_num = i + 4
        constraint = fin.readline().split()

        c = constraint # Creating an alias for easy reference
        m = output_ordering_map # Creating an alias for easy reference

        person_a = m[c[0]]
        person_b = m[c[1]]
        person_mid = m[c[2]]

        if (person_a < person_mid < person_b) or (person_b < person_mid < person_a):
            constraints_failed.append(c)
        else:
            constraints_satisfied += 1

    return constraints_satisfied, num_constraints, constraints_failed

if __name__ == '__main__':
    main(sys.argv[1:])
