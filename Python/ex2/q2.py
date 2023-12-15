import pandas as pd
import pingouin as pg
from sklearn.linear_model import LinearRegression

# 读取数据
data = pd.read_csv("b2.csv", encoding="utf-8")
X = data.drop(["性别", "y"], axis=1)

# 计算相关系数矩阵
cor = data.drop("性别", axis=1).corr().values
print("y与x1的相关系数: {}".format(cor[0][1]))
print("y与x2的相关系数: {}".format(cor[0][2]))
print("y与x3的相关系数: {}".format(cor[0][3]))
print("y与x4的相关系数: {}".format(cor[0][4]))

# 计算偏相关系数
df = pd.DataFrame(data, columns=["x1", "x2", "x3", "x4", "y"])
print("y与x1,x2的偏相关系数:{}".format(pg.partial_corr(data=df, x='x1', y='y', covar=['x2'])))
print("y与x1,x3的偏相关系数:{}".format(pg.partial_corr(data=df, x='x1', y='y', covar=['x3'])))
print("y与x1,x4的偏相关系数:{}".format(pg.partial_corr(data=df, x='x1', y='y', covar=['x4'])))
print("y与x2,x3的偏相关系数:{}".format(pg.partial_corr(data=df, x='x2', y='y', covar=['x3'])))
print("y与x2,x4的偏相关系数:{}".format(pg.partial_corr(data=df, x='x2', y='y', covar=['x4'])))
print("y与x3,x4的偏相关系数:{}".format(pg.partial_corr(data=df, x='x3', y='y', covar=['x4'])))

# 计算回归方程
# -1 1转换为不知道有几行但只有一列的矩阵
Y = data["y"].values.reshape(-1, 1)

f = LinearRegression()
f.fit(X, Y)

k = f.coef_  # 斜率
c = f.intercept_  # 常量c
print("回归方程为: y = {} * x1 + {} * x2 + {} * x3 + {} * x4 + {}"
      .format(k[0][0], k[0][1], k[0][2], k[0][3], c[0]))
