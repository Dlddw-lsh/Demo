import pandas as pd
from sklearn.cluster import AgglomerativeClustering

data = pd.read_csv('data.csv', encoding="utf-8")
# 删除酒
data = data.drop(["酒"], axis=1)
# 计算层次聚类 linkage=complete表示最大距离法作为测试方法 metric=cosine表示余弦做为距离度量
model = AgglomerativeClustering(n_clusters=3, metric='cosine', linkage='complete')
clusters = model.fit_predict(data)
# 打印分类矩阵
print("分类矩阵:", clusters)
