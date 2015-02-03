// Using the input value 2.7255, generate the string "You owe $2.73 dollars". Is this doable with string interpolation?

val youOwe = f"You owe $$${2.7255}%.2f dollars"

def youOweF(money: Double) = f"You owe $$${money}%.2f dollars";
youOweF(2.7255)