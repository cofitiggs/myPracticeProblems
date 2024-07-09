from collections import deque

PIPES_AND_CONNECTIONS = {
    # format of openings: up, right, down, left
    "═": [False, True, False, True],
    "║": [True, False, True, False],
    "╔": [False, True, True, False],
    "╗": [False, False, True, True],
    "╚": [True, True, False, False],
    "╝": [True, False, False, True],
    "╠": [True, True, True, False],
    "╣": [True, False, True, True],
    "╦": [False, True, True, True],
    "╩": [True, True, False, True]
}


def is_connected(cell1, cell2, direction):
    # Treat source and sinks as having openings on all sides
    non_pipes = "*ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    cell_1_connections = [True, True, True, True] if cell1 in non_pipes else PIPES_AND_CONNECTIONS[cell1]
    cell_2_connections = [True, True, True, True] if cell2 in non_pipes else PIPES_AND_CONNECTIONS[cell2]

    if direction == "up":
        return cell_1_connections[0] and cell_2_connections[2]
    elif direction == "right":
        return cell_1_connections[1] and cell_2_connections[3]
    elif direction == "down":
        return cell_1_connections[2] and cell_2_connections[0]
    else:
        return cell_1_connections[3] and cell_2_connections[1]


def move_in_bounds(new_x, max_x, new_y, max_y):
    return 0 <= new_x < max_x and 0 <= new_y < max_y


def connected_sink_system(file_path):
    grid_data = []
    with open(file_path, "r") as file:
        for line in file:
            line = line.strip()
            if line:
                parts = line.split()
                sink_or_pipe = parts[0]
                x_coord = int(parts[1])
                y_coord = int(parts[2])
                grid_data.append((sink_or_pipe, x_coord, y_coord))

    # these variables will help for initializing the grid
    max_x = max(data[1] for data in grid_data) + 1
    max_y = max(data[2] for data in grid_data) + 1

    # initialize an empty nested list for our grid
    grid = [[' ' for _ in range(max_x)] for _ in range(max_y)]

    # Now we need to place all the objects into the grid
    for elem in grid_data:
        sink_or_pipe, x_coord, y_coord = elem
        grid[y_coord][x_coord] = sink_or_pipe

    # Find source and sinks
    source_coords = None
    sinks_and_coords = []

    for data in grid_data:
        sink_or_pipe, x_coord, y_coord = data
        if sink_or_pipe == '*':
            source_coords = (x_coord, y_coord)
        elif sink_or_pipe.isalpha():
            sinks_and_coords.append((sink_or_pipe, x_coord, y_coord))

    # If there are no sinks nor sources, the solution should be an empty string
    if not source_coords or not sinks_and_coords:
        return ""

    def bfs(start):
        # bfs setup
        queue = deque([start])
        visited = {start}
        connected_sinks = set()

        directions = {"up": [0, -1], "right": [1, 0], "down": [0, 1], "left": [-1, 0]}

        while queue:
            x_coord, y_coord = queue.popleft()
            point_1_content = grid[y_coord][x_coord]

            if not point_1_content.isspace():
                for key, (x_dist, y_dist) in directions.items():
                    current_direction = key
                    new_x_coord = x_coord + x_dist
                    new_y_coord = y_coord + y_dist

                    # Will the point we move to be within the grid's bounds?
                    if move_in_bounds(new_x_coord, max_x, new_y_coord, max_y):
                        point_2_content = grid[new_y_coord][new_x_coord]

                        # Has the point not been previously visited and is it not an empty space?
                        if not point_2_content.isspace() and (new_x_coord, new_y_coord) not in visited:
                            # Is it connected to our current space?
                            if is_connected(point_1_content, point_2_content, current_direction):
                                # If all conditions are satisfied, then we mark the new point as visited:
                                visited.add((new_x_coord, new_y_coord))
                                # and then add the new point to the queue:
                                queue.append((new_x_coord, new_y_coord))

                                # If the new point is a letter representing a sink, we add it to our solution set:
                                if grid[new_y_coord][new_x_coord].isalpha():
                                    connected_sinks.add(point_2_content)

        return connected_sinks

    connected = bfs(source_coords)
    return "".join(sorted(connected))

print(connected_sink_system(file_path="coding_qual_input.txt"))
