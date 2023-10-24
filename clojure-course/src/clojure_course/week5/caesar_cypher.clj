(ns clojure-course.week5.caesar-cypher
  (:require [clojure-course.week5.caesar-cypher-init-data :as caesar])
  (:require [clojure.string :as string :only [split upper-case index-of]])
  )

(def phrase_to_encode (string/upper-case "per aspera ad astra"))
(def cypher_key 3)
(def alphabet_size (count caesar/alphabet))

(def encode_letter_routine
  (fn [letter_index key]
    (mod (+ letter_index key) alphabet_size)
  )
  )

(def decode_letter_routine
  (fn [letter_index key]
    (mod (- letter_index key) alphabet_size)
    )
  )


(defn conversion
  [phrase_to_encode key encoded_word routine]
  (let [first_letter (first phrase_to_encode)
        letter_index (string/index-of caesar/alphabet first_letter)
        encoded_index (routine letter_index key)
        encoded_letter (get caesar/alphabet encoded_index)
        ;_ (println first_letter ">" encoded_letter)
        ;_ (println "encoded_word =" encoded_word)
        ]
      (if (> (count phrase_to_encode) 1)
        (conversion (subs phrase_to_encode 1) key (str encoded_word encoded_letter) routine)
        (str encoded_word encoded_letter)
        )
    )
  )

;(println "phrase to encode=" phrase_to_encode)
;(def encoded_phrase (conversion phrase_to_encode cypher_key "" encode_letter_routine))
;(println "encoded phrase=" encoded_phrase)
;(def decoded_phrase (conversion encoded_phrase cypher_key "" decode_letter_routine))
;(println "decoded phrase=" decoded_phrase)



