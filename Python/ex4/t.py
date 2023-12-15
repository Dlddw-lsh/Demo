import pandas as pd
import numpy as np
from factor_analyzer import FactorAnalyzer
from sklearn.decomposition import FactorAnalysis
from sklearn.preprocessing import StandardScaler

data = pd.read_csv('data.CSV', index_col=0)

# 数据标准化
scaler = StandardScaler()
standardData = scaler.fit_transform(data)

fa = FactorAnalyzer(n_factors=3, rotation=None)
fa.fit(data)
# 获取因子载荷
loadings = fa.loadings_

# 进行因子分析
tf = FactorAnalysis(n_components=3, random_state=0)
xTf = tf.fit_transform(standardData)

print("因子载荷:")
print(loadings)
print("\n转化后的数据:")
print(xTf)

factorScores = np.dot(data, loadings)

composite_scores = factorScores.sum(axis=1)
rankCom = pd.DataFrame({'公司': data.index, '得分': composite_scores})
rankCom = rankCom.sort_values(by='得分', ascending=False)

print("公司综合排名:")
print(rankCom)
