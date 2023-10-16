(ns clojure-course.week2.loops-demo)

; loop int value from 0 to 10
(loop [x 0]
  (if (> x 10)
    (do
      ; we return x and stop the loop. it works as return.
      x
      )
    (do
      (println "x=" x)
      ; otherwise...
      ; the next row increases i on 1 and goes back to loop function
      ; to perform the next iteration
      (recur (inc x))
      )
    )
  )

(println "-----------------")
; this is atom. It points to a variable in memory we can change.
; we call it "y" and set value as 0
(def y (atom 0))
; loop int value from 0 to 10
; remember, "y" points to some object in memory.
; If you print "y", you will see something like "object...". This is Java toString() method.
; got get value of atom, use "@" symbol
(while (<= @y 10)
  (println "y=" @y)
  ; this function applies the function standing on second position
  ; on the atom standing on the first position
  ; it is the same as (inc @y)
  (swap! y inc)
  )

(println "-----------------")
