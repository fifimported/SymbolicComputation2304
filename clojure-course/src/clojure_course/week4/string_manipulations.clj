(ns clojure-course.week4.string-manipulations)
(require '[clojure.string :as string])

(def str_friend "my friend!")
(println (get str_friend 3))
;(println (first str_friend))
;(println (last str_friend))
;(println (subs str_friend 3 9))
;(println (subs str_friend 3))
(def str_text "Sentence number one. Sentence number two.")
(def str_split (string/split str_text #"\."))

;(println str_split)
;(println (count str_split))
(def taco_cat "taco cat")
(def taco_cat_reversed (reverse taco_cat))
(def taco_cat_reversed_str (apply str taco_cat_reversed))

;palindrome
(println "plane >" taco_cat "; reversed >> " taco_cat_reversed "; reversed str >> " taco_cat_reversed_str)








