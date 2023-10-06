(ns clojure-course.week2.koschey-abracadabra-tasks-soojin-jeong)

(def func_combine_letters
  (comp #(println "magic word! = " %) #(str "abra"  %) #(str "cad" %))
  )

(func_combine_letters "abra")

(defn chest [str]
  ((fn duck [str]
     ((fn jackrabbit [str]
        ((fn egg [str]
           ((fn needle [str]
              (println str)
              "Break the needle!"
              str)
            str))
         str))
      str))
   str))

(chest "Break the needle!")
