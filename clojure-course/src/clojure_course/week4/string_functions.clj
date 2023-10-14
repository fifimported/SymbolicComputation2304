(ns clojure-course.week4.string-functions
  (:require [clojure.string :as string :only [index-of, last-index-of, trim]]))


(println (str 123))
(println (str 1 2 3))
(println (str [1 2 3]))
(println (apply str [1 2 3]))
;(println (format "Hello, %s" "my friend!"))
;(println (format "This is 165 >>> %X" 165))
;(println (format "Leading zeros %07d" 1234))
;(println (format "Float formatting %.3f" 3.14563223))
;(println (count "my friend!"))

;(def abra "abracadabra")
;(println (string/index-of abra "r"))
;(println (string/last-index-of abra "r"))
;(def london "     London is the capital of Great Britain     ")
;(println (string/trim london))









