(ns clojure-course.week5.mafia-boss-init-data)

; hint: start with a henchman of maximum level (key)
; if there is another henchman a level below, first calculate his tribute
; and then add it to your tribute
(def henchmen
  {
   1 [100 200]
   2 [250 300]
   3 [400 100]
   }
  )
