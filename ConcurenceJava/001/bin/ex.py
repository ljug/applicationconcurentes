import sys

def f(x):
    result=0
    #do something
    #juste un exemple
    result=x+1
    return result

while(True):
    param=input()
    if param == "stop":
        print("end")
        sys.stderr.write("ok\n")
        sys.stderr.flush()
        break;
    #unmarshal param : from string to your  type
    res=f(int(param))
    #marshal result from res type to string
    print(res)
    print("end")
    sys.stderr.write("ok\n")
    sys.stderr.flush()
