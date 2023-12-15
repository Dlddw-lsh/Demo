import numpy as np

# 获取矩阵D
D = np.loadtxt('../res/test1-2.csv', delimiter=",", dtype=np.intc)
print("矩阵D为\n{}".format(D))

# 获取转置矩阵
G = D.T
print("D的转置为\n{}".format(G))

# 协方差矩阵
E = np.cov(G)
print("G的协方差矩阵:\n{}".format(E))
# 相关系数矩阵
F = np.corrcoef(G)
print("G的相关系数矩阵:\n{}".format(F))

# 求解矩阵E和矩阵F的特征值和特征向量；
a, b = np.linalg.eig(E)
print("E的特征值为{}\n特征向量为{}".format(a, b))
a, b = np.linalg.eig(F)
print("F的特征值为{}\n特征向量为{}".format(a, b))
