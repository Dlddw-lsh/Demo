import numpy as np

data = list(map(float, input().split(',')))
m, n = map(int, input().split(','))
data = np.reshape(data, [m, n])
x = (data - np.mean(data)) / np.std(data)

cov = np.cov(x.T)
u, v = np.linalg.eig(cov)

if u[0] > u[1]:
    index = 0
else:
    index = 1

a = v[0][index]
b = np.mean(data, axis=0)[0]
c = v[1][index]
d = np.mean(data, axis=0)[1]

print("第1主成分={:.5f}*(x1-{:.2f}){:+.5f}*(x2-{:.2f})".format(a, b, c, d))
