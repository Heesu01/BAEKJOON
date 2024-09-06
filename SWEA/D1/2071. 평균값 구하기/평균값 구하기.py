T = int(input())
for test_case in range(1, T + 1):
	num = list(map(int, input().split()))
	avg = int(round(sum(num) / 10, 0))
    
	print(f"#{test_case} {avg}")