for i in range(0,3):
    num = input()
    if num not in ['Fizz', 'Buzz', 'FizzBuzz']:
        n = int(num)+3-i
        
if n%15==0:
    print("FizzBuzz")
elif n%3==0:
    print("Fizz")
elif n%5==0:
    print("Buzz")
else:
    print(n)