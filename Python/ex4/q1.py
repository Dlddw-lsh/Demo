# 步骤1: 导入必要的库
import pandas as pd
from sklearn.decomposition import FactorAnalysis
from sklearn.preprocessing import StandardScaler

# 步骤2: 读取数据
data = pd.read_csv('data.csv', index_col=0)

# 步骤3: 数据标准化
scaler = StandardScaler()
data_scaled = scaler.fit_transform(data)

# 步骤4: 使用 FactorAnalysis 进行因子分析
# n_components 表示要提取的因子个数
transformer = FactorAnalysis(n_components=3, random_state=0)
X_transformed = transformer.fit_transform(data_scaled)
# 输出转化后的数据和因子载荷矩阵
print("转化后的数据:")
print(X_transformed)
print("\n因子载荷矩阵:")
print(transformer.components_)
