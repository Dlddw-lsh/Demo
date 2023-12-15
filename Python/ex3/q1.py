import pandas as pd
from sklearn.cluster import AgglomerativeClustering

data = pd.read_csv('data.csv', encoding="utf-8")
# 删除酒
data = data.drop(["酒"], axis=1)
# 计算层次聚类 linkage=single为最小距离测试方法 metric=euclidean为欧式距离作为距离度量
model = AgglomerativeClustering(n_clusters=3, metric='euclidean', linkage='single')
clusters = model.fit_predict(data)
# 打印分类矩阵
print("分类矩阵:", clusters)
