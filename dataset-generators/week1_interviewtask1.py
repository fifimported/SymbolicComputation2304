# Generates a vector for IT 1-1 (sum of two numbers equals target)
import math
import random

max_border = int(math.pow(10, 5))
vector_len = int(math.pow(10, 4))

target = random.randint(-max_border, max_border)
v1 = random.randint(0, abs(target) - 1)
v2 = target - v1
pos1 = -1
pos2 = -1
while pos1 == pos2:
	pos1 = random.randint(1, vector_len)
	pos2 = random.randint(1, vector_len)

output_vector = [0] * vector_len

print(f"Generate {vector_len} numbers in [{-max_border}, {max_border}].")

for i in range(0, vector_len):
	v = target
	checked = False
	while not checked:
		v = random.randint(-max_border, max_border)
		checked = (v != v1) and (v != v2) and (not target - v in output_vector)
	output_vector[i] = v

output_vector[pos1] = v1
output_vector[pos2] = v2
closure_txt = "(ns clojure-course.week1.input_vector_interview_task1)\r\n"
closure_txt = f"{closure_txt} (def target {target})\r\n"
closure_txt = f"{closure_txt} (println \"Estimated Results: Position1={pos1}. Position2={pos2}. Val1={v1}. Val2={v2}. \")\r\n"
closure_txt = f"{closure_txt} (def input_vector ["
for s in output_vector:
	closure_txt = closure_txt + str(s) + " "
closure_txt = closure_txt.rstrip() + "])"

js_txt = ""
for s in output_vector:
	js_txt = js_txt + str(s) + " "
js_txt = "var input_vector = [" + js_txt.rstrip().replace(" ", ",") + "];"

f = open("input_vector_interview_task1.clj", "w")
f.write(closure_txt)
f.close()

f = open("input_vector_interview_task1.js", "w")
f.write(js_txt)
f.close()

metadata = [f"Target={target}. Val1={v1}. Val2={v2}. Position1={pos1}. Position2={pos2}."]

f = open("metadata.txt", "w")
f.writelines(metadata)
f.close()








