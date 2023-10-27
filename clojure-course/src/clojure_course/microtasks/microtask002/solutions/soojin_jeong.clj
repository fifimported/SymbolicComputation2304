(ns clojure-course.microtasks.microtask002.solutions.soojin-jeong)

;Xavier the Wizard decided to grow and sell a gold dragon. When the dragon had hatched, Xavier realized it was green, not gold. The time has come to deliver the dragon to the buyer, and Xavier decides to take a desperate step: repaint the dragon. Let's calculate how many cans of yellow paint the wizard required.
;You may split the dragon into rectangles: head and neck (2 m x 3 m), body and paws (5 m x 4 m), and tail (1 m x 3 m). For each square meter, Xavier needs two cans.
;Fingers crossed for Xavier! I hope his trick survives the very first rain.
;
;Try your best:
;1) use a function for rectangle-square calculation.
;2) you may put a pair of values in a vector and use it in a loop.
;3) advanced: is it possible to use the "map" function? You may get documentation via "(doc map)" or check clojure.org.

;using loop
(defn rectangle-square1
  [len wid]
  (* len wid)
  )

(def dragon1 [[2 3] [5 4] [1 3]])

(def paint-per-squ-meter1 2)

(def cans-needs1
  (apply + (for [[len wid] dragon1]
             (* (rectangle-square1 len wid) paint-per-squ-meter1) ))
  )

(println "I need" cans-needs1 "yellow paints for paint dragon!")

(defn rectangle-square2
  [len wid]
  (* len wid)
  )

(def dragon2 [[2 3] [5 4] [1 3]])

(def paint-per-squ-meter2 2)

(def cans-needs2
  (apply + (map #(->> % (apply rectangle-square2) (* paint-per-squ-meter2)) dragon2)))


(println "I need" cans-needs2 "yellow paints for paint dragon!")



