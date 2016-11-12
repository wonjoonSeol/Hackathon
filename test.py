f = open(sys.argv[1], "r")
lines = f.readlines()
f.close()

for line in lines:
	print("System.out.println(\"" + line.replace("\\", "\\\\") + "\");")
