while True:
    mem=list(input().split())
    if mem[0]=="#" and mem[1]=="0" and mem[2]=="0":
        break
    elif int(mem[1])>17 or int(mem[2])>=80:
        print(mem[0]+" Senior")
    else:
        print(mem[0]+" Junior")
        
        