import pandas as pd
import numpy as np
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
from sklearn.naive_bayes import GaussianNB

data = pd.read_csv("b3.csv", encoding="utf-8")
# 结果集
y = data["级别"].values
x = data.drop(["序号", "级别"], axis=1).values.reshape(-1, 3)
newData = np.array([[38, 61, 59]])
# Fisher判别
lda = LinearDiscriminantAnalysis()
lda.fit(x, y)
ldaResult = lda.predict(newData)
score = lda.score(x, y)
print("Fisher判别的结果是", ldaResult[0])
print("误判率：", 1 - score)

# Bayes判别
gnb = GaussianNB()
gnb.fit(x, y)
gnbResult = gnb.predict(newData)
score = gnb.score(x, y)
print("Bayes判别的结果是", gnbResult[0])
print("误判率：", 1 - score)