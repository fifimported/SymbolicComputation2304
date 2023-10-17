(ns clojure-course.week4.the-longest-palindrome-roman-yepanchenko)

; 2d vector where every value is a vector that was generated from input string (
(def palindromesTable [])

; 1 if value is equal to letter that referenced by key, 0 is not equal
; a > 0 [1 0 0 0]
; m > 1 [0 1 0 1]
; 0 > 2 [0 0 1 0]
; m > 3 [0 1 0 1]
; we could find palindromes if we'll loop from the top to down
; every diagonal line from top to left could be a palindrome if every cell in a line equal to 1,
(def palindromesTableState [])

; Just quality of life things
(def stringLength 0)
(def palindromesTableMaxIndex 0)
(def defaultMapValue [])

; Used in while function
(def globalState true)
(def p1 0)
(def p2 0)

;
(def maxPalindrome "")
(def currentPalindrome "")

(defn init
  [inputString]

  ; Generate a vector of zeros by the input string length
  (def defaultMapValue (into [] (map (fn [x] 0) inputString)))

  (def stringLength (count inputString))
  (def palindromesTableMaxIndex (- stringLength 1))

  ; Set palindromesTable by zeros
  (doseq [value inputString]
    (def palindromesTableState (conj palindromesTableState defaultMapValue))
    )

  (doseq [[i1 value1] (map-indexed vector inputString)]
    (doseq [[i2 value2] (map-indexed vector inputString)]

      ; Fill palindromesTable by letters
      (def palindromesTable (assoc palindromesTable i1 (assoc (get palindromesTable i1) i2 value2)))

      ; If value1 is equal to value2 then update a value in coordinates l1.l2 by 1
      (if (= value1 value2)
        (def palindromesTableState (assoc palindromesTableState i1 (assoc (get palindromesTableState i1) i2 1)))
        )
      )
    )

  ; The main piece of code
  (doseq [[i1 value1] (map-indexed vector palindromesTableState)]

    (doseq [[i2 value2] (map-indexed vector value1)]
      ; debug (> i2 0)
      ;
      (if (= value2 1)
        (do

          ; It's the next symbol coordinates
          (def p1 i1)
          (def p2 i2)

          (def globalState true)

          (while (= globalState true)

            ; if the next letter coordinates is not out of bound
            (if (and (<= p1 palindromesTableMaxIndex) (>= p2 0))
              (do
                ; if the next letter state is 1
                (if (= (get (get palindromesTableState p1) p2) 1)
                  ; then we can add the letter from the coordinates to the end of the current palindrome variable
                  (def currentPalindrome (str currentPalindrome (get (get palindromesTable p1) p2)))
                  )

                ; update coordinates by shift if down and left in the 2d table
                (def p1 (+ p1 1))
                (def p2 (- p2 1))
                )
              (do
                ; If current currentPalindrome is bigger than maxPalindrome then update maxPalindrome
                (if (> (count currentPalindrome) (count maxPalindrome))
                  (def maxPalindrome currentPalindrome)
                  )

                ; Clean and exit from the loop
                (def currentPalindrome "")
                (def globalState false)
                )
              )
            )
          )
        )
      )
    )

  (println maxPalindrome)

  ; Debug
  ; (println palindromesTable)
  ; (run! println palindromesTable)
  ; (run! println palindromesTableState)
  )

(init "agrnd1fsnunttrrmomg245dftacocatj5ngmds")

; (if (= (getCurrentResponseLength) 0)
;  )
