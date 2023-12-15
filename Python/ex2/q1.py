import pandas as pd
from sklearn.linear_model import LinearRegression

data = pd.read_csv("b1.csv", encoding="utf-8")
# 计算相关系数
cor = data.corr().values

# 计算回归模型
X = data['可支配收入'].values.reshape(-1, 1)
Y = data['消费性支出'].values.reshape(-1, 1)
f = LinearRegression()
f.fit(X, Y)
k = f.coef_  # 斜率
c = f.intercept_  # 常量c
print(k)
print("可支配收入与消费性支出的相关系数：{:}".format(cor[0][1]))
print("回归方程为: y = {} * x + {}".format(k[0][0], c[0]))
