from fractions import Fraction

import numpy as np

# 生成A B矩阵s
A = np.array(
    [[-1, 3, 2],
     [5, 7, -2],
     [-3, 0, 1]])
B = np.array(
    [[8, 2, -1],
     [6, 4, 0],
     [-2, 3, 5]])

# A + B
print("A+B:\n{}".format(np.add(A, B)))

# A - B
print("A-B:\n{}".format(np.subtract(A, B)))

# 叉乘
print("AxB:\n{}".format(np.cross(A, B)))

# 点乘 A@B
print("A·B:\n{}".format(np.dot(A, B)))

# 计算C的逆矩阵和行列式
C = A * B
# C的逆矩阵
np.set_printoptions(formatter={'all': lambda x: str(Fraction(x).limit_denominator())})
invC = np.linalg.inv(C)
print("C的行列式:\n{}".format(np.linalg.det(C)))
print("C的逆矩阵:\n{}".format(invC))


# 验证C与C的逆相乘是否为单位矩阵
def is_identity_matrix(matrix):
    rows = len(matrix)
    cols = len(matrix[0])
    if rows != cols:
        return False
    for i in range(rows):
        for j in range(cols):
            if i == j and matrix[i][j] != 1.0:
                return False
            elif i != j and matrix[i][j] >= 1e-16:
                return False
    return True


t = np.dot(C, invC)
print("矩阵：\n{}\n是否为单位矩阵:{}".format(t, is_identity_matrix(t)))
