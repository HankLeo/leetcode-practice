def spiral_order(matrix: list[list[int]]) -> list[int]:
    if not matrix or not matrix[0]:
        return list()

    m, n = len(matrix), len(matrix[0])
    order = list()
    left, right, top, bottom = 0, n - 1, 0, m - 1
    while left <= right and top <= bottom:
        # left -> right
        for col in range(left, right + 1):
            order.append(matrix[top][col])
        if top == bottom:
            break
        # top -> bottom
        for row in range(top + 1, bottom + 1):
            order.append(matrix[row][right])
        if left == right:
            break
        # right -> left
        for col in range(right - 1, left - 1, -1):
            order.append(matrix[bottom][col])
        # bottom -> top
        for row in range(bottom - 1, top, -1):
            order.append(matrix[row][left])
        left, right, top, bottom = left + 1, right - 1, top + 1, bottom - 1
    return order


if __name__ == "__main__":
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(spiral_order(matrix))
