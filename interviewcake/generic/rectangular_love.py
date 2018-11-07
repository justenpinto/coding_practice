def find_intersection(r1, r2):
    if r1['left_x'] + r1['width'] <= r2['left_x']:
        raise Exception('Rectangles do not cross, R1 is too far left.')

    if r1['left_x'] >= r2['left_x'] + r2['width']:
        raise Exception('Rectangles do not cross, R2 is too far left.')

    if r1['bottom_y'] >= r2['bottom_y'] + r2['height']:
        raise Exception('Rectangles do not cross, R1 is too far up.')

    if r2['bottom_y'] >= r1['bottom_y'] + r1['height']:
        raise Exception('Rectangles do not cross, R2 is too far up.')

    intersected_rectange = dict()

    determine_point_and_directional_magnitude(r1, r2, intersected_rectange, 'bottom_y', 'height')
    determine_point_and_directional_magnitude(r1, r2, intersected_rectange, 'left_x', 'width')

    return intersected_rectange


def determine_point_and_directional_magnitude(r1, r2, intersected_rectangle, coordinate_singularity,
                                              directional_magnitude):
    if r1[coordinate_singularity] < r2[coordinate_singularity]:
        intersected_rectangle[coordinate_singularity] = r2[coordinate_singularity]
        intersected_rectangle[directional_magnitude] = r1[coordinate_singularity] + r1[directional_magnitude] - r2[
            coordinate_singularity]
    else:
        intersected_rectangle[coordinate_singularity] = r1[coordinate_singularity]
        intersected_rectangle[directional_magnitude] = r2[coordinate_singularity] + r2[directional_magnitude] - r1[
            coordinate_singularity]


if __name__ == '__main__':
    r1 = {
        'left_x': 1,
        'bottom_y': 1,
        'width': 6,
        'height': 3
    }
    r2 = {
        'left_x': 5,
        'bottom_y': 2,
        'width': 3,
        'height': 6
    }
    print(find_intersection(r1, r2))
