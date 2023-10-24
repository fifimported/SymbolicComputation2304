(ns clojure-course.week5.caesar-cypher-kirill-marchenko
  (:require [clojure.string :as str])
  )

(def alphabet_map
  {
   0 "A",
   1 "B",
   2 "C",
   3 "D",
   4 "E",
   5 "F",
   6 "G",
   7 "H",
   8 "I",
   9 "J",
   10 "K",
   11 "L",
   12 "M",
   13 "N",
   14 "O",
   15 "P",
   16 "Q",
   17 "R",
   18 "S",
   19 "T",
   20 "U",
   21 "V",
   22 "W",
   23 "X",
   24 "Y",
   25 "Z"
   })

(defn encrypt [word, shift]
  (let [upper_word (str/upper-case word) word_vec (str/split upper_word #"") mutable-str (StringBuilder.)]
    (doseq [letter word_vec]
      (doseq [alphabet_letter alphabet_map]
        (if(= letter (val alphabet_letter))
          (.append mutable-str (get alphabet_map (+ (key alphabet_letter) shift)))
          )
        ))
    (println (.toString mutable-str))
    ))

(defn encrypt-sentence [sentence shift]
  (let [sentence_vec (str/split sentence #" ")]
    (doseq [word sentence_vec]
      (encrypt word shift)
      ))
  )
(defn decrypt [word, shift]
  (let [upper_word (str/upper-case word) word_vec (str/split upper_word #"") mutable-str (StringBuilder.)]
    (doseq [letter word_vec]
      (doseq [alphabet_letter alphabet_map]
        (if(= letter (val alphabet_letter))
          (.append mutable-str (get alphabet_map (- (key alphabet_letter) shift)))
          )
        ))
    (println (.toString mutable-str))
    ))
(defn decrypt-sentence [sentence, shift]
  (let [sentence_vec (str/split sentence #" ")]
    (doseq [word sentence_vec]
      (decrypt word shift)
      ))
  )


(encrypt-sentence "some sentence" 1)
(decrypt-sentence "TPNF TFOUFODF" 1)







