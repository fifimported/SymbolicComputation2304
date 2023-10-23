(ns clojure-course.week5.caesar-cypher-calc
  (:require [clojure.string :as string :only [upper-case index-of]])
  (:require [clojure-course.week5.caesar-cypher-init-data :as init_data])
  (:require [clojure-course.week5.caesar-cypher :as caesar])
  )

(def index_of_e (string/index-of init_data/alphabet "E" ))
(println "index of E letter in English alphabet=" index_of_e)
; most frequent letter in the encrypted string
(def most_frequent_letter "")
(def most_frequent_letter_index (string/index-of init_data/alphabet most_frequent_letter ))
(def cypher-key-candidate (mod (- most_frequent_letter_index index_of_e) caesar/alphabet_size))
(println "cypher-key-candidate=" cypher-key-candidate)

(def encoded_phrase "")
(println "result of decryption =" (caesar/conversion encoded_phrase cypher-key-candidate "" caesar/decode_letter_routine))



