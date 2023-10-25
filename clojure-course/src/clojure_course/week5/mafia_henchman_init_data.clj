(ns clojure-course.week5.mafia-henchman-init-data)

; hint: you may check each vector.
; If the first element is not a string -- you need to dive deeper.
; (string? some_string)

(def tribute_payers
  [
   ["Bar" 200]
   [
    ["hotdog stall" 100]
    [
     ["repair shop" 200]
     ["grocery shop" 300]
     ["disco club" 250]
     ]
     ["pawnshop" 400]
    ]
   ]
  )
