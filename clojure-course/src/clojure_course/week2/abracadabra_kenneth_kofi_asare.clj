(ns clojure-course.week2.abracadabra-kenneth-kofi-asare)

(def magic_by_comp
  (comp #(println "magic_by_comp=" %) #(str % "abra") #(str % "cad") #(str "abra"))
  )

(magic_by_comp)
