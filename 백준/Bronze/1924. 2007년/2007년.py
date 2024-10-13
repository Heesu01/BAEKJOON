cnt = [0, 31, 28, 31, 30,31,30,31,31,30,31,30,31]
ans = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
m, d = map(int, input().split())
sum=0
for i in range(m):
    sum += cnt[i]
sum += d
print(ans[sum%7])