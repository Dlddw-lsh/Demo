import numpy as np
from sklearn.cluster import AgglomerativeClustering

variables = list(map(float, input().split()))
m, n = map(int, input().split())
num = int(input())
data = np.reshape(variables, [m, n]).T

# 计算相关系数
model = AgglomerativeClustering(n_clusters=num, metric='correlation', linkage='complete')
clusters = model.fit(data)
print(clusters)
label = clusters.labels
print(label)
if label[0] == label[2]:
    print("香气和酸质属于一类。")
else:
    print("香气和酸质不属于一类。")
