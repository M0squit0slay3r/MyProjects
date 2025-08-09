def get_number(number):
    while True:
        number1 = input(f"Number {number}:")
        try:
            return float(number1)
        except:
            print("Invalid number, try again")

number1 = get_number(1)
number2 = get_number(2)

sign = input ("Sign: ")

result = 0 

if sign == "+":
    result = float(number1) + float(number2)
elif sign == "-":
    result = float(number1) - float(number2)
elif sign == "/":
    if float(number2) != 0:
        result = float(number1) / float(number2)
    else:
        print("Division by zero.")
elif sign =="*":
    result = float(number1) * float(number2)

print(result)


## valid = False
## try:
##    number1 = float(number1)
##    number2 = float(number2)
##    valid = True
##  except:
##    print("Invalid operands.")

#or  
#   try:
#       ...
#       ...
#   except:
#       ...

