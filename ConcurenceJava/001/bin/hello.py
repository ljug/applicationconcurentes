
import sys
# Les arguments, ligne de commande du processus
print("Hello NFP103 dit ACCOV")
print(f"Nbr param = {len(sys.argv)}")
for arg in sys.argv:
   print(arg,end=' ')
print()
# l'entree standard
line=""
while(line != "quit"):
  line=input("> ")
  print(line)


