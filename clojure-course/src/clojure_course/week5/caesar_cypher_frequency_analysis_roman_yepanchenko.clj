(ns clojure-course.week5.caesar_cypher_frequency_analysis_roman_yepanchenko
  (:require [clojure-course.week5.caesar-cypher-roman-yepanchenko :as CaesarCypher :only [encrypt, decrypt]])
  (:require [clojure.set :as clojure.set :only [map-invert]])
  )

(defn findFrequencies
  [encryptedString latinAlphabetMap]

  (let [
        latinAlphabetMap latinAlphabetMap
        encryptedString encryptedString
        frequencyMap (atom {})
        ]

    (doseq [value encryptedString]
      (if (contains? latinAlphabetMap value)
        (do
          (if (contains? @frequencyMap value)
            (do
              (reset! frequencyMap (assoc @frequencyMap value (+ (get @frequencyMap value) 1)))
              )
            (do
              (reset! frequencyMap (assoc @frequencyMap value 1))
              )
            )
          )
        )
      )

    ; make an array from a sorted by descending value map
    (into [] (sort-by val #(compare %2 %1) @frequencyMap))
    )
  )

(defn break
  [encryptedString latinAlphabetString]

  (let [
        ; Generate latinAlphabetMap by latinAlphabetString, where keys are letters and values are indexes of letters
        latinAlphabetMap (clojure.set/map-invert (into {} (map-indexed vector latinAlphabetString)))
        triesMax (atom 2)
        triesCounter (atom 0)
        frequencies (atom [])
        ]

    ; An array that have sub arrays with letter at index 0 and a counter at index 1
    (reset! frequencies (findFrequencies encryptedString latinAlphabetMap))

    (doseq [value @frequencies]

      (if (< @triesCounter @triesMax)
        (do
          (println "")
          (println "encrypted variant, offset" (- (get latinAlphabetMap (get value 0)) (get (first latinAlphabetMap) 1)))

          ; print decrypted string by difference between letter in frequencies loop and letter A
          (println (CaesarCypher/decrypt encryptedString (- (get latinAlphabetMap (get value 0)) (get (first latinAlphabetMap) 1))))
          )
        )

      (reset! triesCounter (inc @triesCounter))
      )
    )


  )

;
;  Init
;

(def stringForDecryption "CAESAR WAS AN ACCOMPLISHED AUTHOR AND HISTORIAN AS WELL AS A STATESMAN MUCH OF HIS LIFE IS KNOWN FROM HIS OWN ACCOUNTS OF HIS MILITARY CAMPAIGNS")
(def stringForDecryptionOffset 10)

(println(CaesarCypher/encrypt stringForDecryption stringForDecryptionOffset))
;(println(CaesarCypher/decrypt (CaesarCypher/encrypt stringForDecryption stringForDecryptionOffset) stringForDecryptionOffset))

(break (CaesarCypher/encrypt stringForDecryption stringForDecryptionOffset) "ABCDEFGHIJKLMNOPQRSTUVWXYZ")



