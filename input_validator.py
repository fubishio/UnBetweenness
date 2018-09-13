import sys

def main(argv):
    if len(argv) != 2:
        print("Usage: python instance_validator.py [path_to_input_file] [num of people]")
        return
    if not int(argv[1]) > 0:
        print("must have positive number of constraints")
        return 
    print(processInput(argv[0], int(argv[1])))

def processInput(s, max_nodes):
    fin = open(s, "r")
    line1 = fin.readline().split()
    # Ensures that the first line contains an integer.
    if len(line1) != 1 or not line1[0].isdigit():
        return "Line 1 must contain a single integer, which is the total number of people at the party."

    # Ensures that the number of objects are between 1 and max node
    N = int(line1[0])
    if N < 1 or N > max_nodes:
        return "N must be between 1 and {max_nodes}.".format(max_nodes=max_nodes)

    # Make sure amount of people matches
    line2 = fin.readline().split()
    if (len(line2) != N):
        return "Line 1 says there are {} people, but line 2 contains {} people".format(N, len(line2))

    # Sets and maps to be consistent
    node_set = set(line2)
    node_map = {k: v for v, k in enumerate(line2)}

    # Needs to be all unique names
    if (len(node_set) != len(line2)):
        return "Duplicate people. There are {} total people, but only {} unique people in the perfect ordering.".format(len(line2), len(node_set))

    # at most 10 letters long, arbitrary, no special symbols
    for people in node_set:
        if not people.isalnum() or len(people) > 10:
            return "people' names must be alphanumeric, and at most 10 characters long."

    # MAkes sure that line 3 is a number between 1 and 500
    line3 = fin.readline().split()
    if len(line3) != 1 or not line3[0].isdigit():
        return "Must be number of age constraints."

    num_constraints = int(line3[0])
    # Consistency with the original ideal order
    for i in range(num_constraints):
        line_num = i + 4
        constraint = fin.readline().split()
        if (len(constraint) != 3):
            return "Line {} (1-index) does not contain 3 people".format(line_num)
        if not set(constraint).issubset(node_set):
            return "In line {}, some person is not in the original list.".format(line_num)

        person_a = node_map[constraint[0]]
        person_b = node_map[constraint[1]]
        person_mid = node_map[constraint[2]]

        if (person_a < person_mid < person_b) or (person_b < person_mid < person_a):
            return "In line {i}, you said {people_mid}'s age was NOT in between {people_a} and {people_b}'s, however, in your optimal ordering, {people_a} appeared at {a_order}, {people_b} appeared at {b_order}, {people_mid} appeared at {mid_order}".format(i = line_num, people_a = constraint[0], people_b = constraint[1], people_mid = constraint[2], a_order = person_a, b_order = person_b, mid_order = person_mid)
            

    # Checks that there are no lines after the number of constraints are exhausted
    if fin.readline().split() != []:
        return "No extra lines"

    return("All Good")

if __name__ == '__main__':
    main(sys.argv[1:])
