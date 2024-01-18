n=int(input())
fi=[]
fi.append(0)
fi.append(1)
for i in range(2,n+1):
    fi.append(fi[i-1]+fi[i-2])
print(fi[n])