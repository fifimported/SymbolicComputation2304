(ns clojure-course.week4.satellite-transmit-roman-yepanchenko)

; Search algorithm for the most long sequence of values that less or equal to maxSum
; For more details, please, see SlidingWindow.clj
; response [index 1, index2]
(defn SearchData
  [inputString, maxSum]

  (let
    [inputString inputString, p1 (atom 0), p2 (atom 1), currentSum (atom 0), response (atom []) maxStringIndex (atom 0) state (atom true) maxSum maxSum]

    (if (= (count inputString) 1)
      (do
        (reset! response [0, 0])
        (reset! state false)
        )

      (do
        (reset! maxStringIndex (- (count inputString) 1))
        (reset! response [@p1, @p2])

        (reset! currentSum (+ (get inputString @p1) (get inputString @p2)))

        )
      )

    (while (= @state true)

      (if (>= @currentSum maxSum)
        ; Increment p1 and update current sum if current sum is greater or equal than maxSum
        (do
          (reset! currentSum (- @currentSum (get inputString @p1)))
          (reset! p1 (+ @p1 1))
          )
        ; else
        (do
          (if (<= (+ @p2 1) @maxStringIndex)
            ; if p2 is less or equal to max index
            ; increment p2 & update current sum
            (do
              (reset! p2 (+ @p2 1))

              (reset! currentSum (+ @currentSum (get inputString @p2)))

              ; and update response if (currentSum less or equal to maxSum) and (current sequence is longer that previous the longest sequence)
              (if (and (<= @currentSum maxSum) (> (+ (- @p2 @p1) 1) (+ (- (get @response 0) (get @response 1)) 1)))
                (reset! response [@p1, @p2])
                )
              )
            ; else stop while
            (do
              (reset! state false)
              )
            )
          )
        )
      )

    ; return response
    @response
    )
  )

(defn init
  [inputValues, perChunk]

  (let
    [inputVector (atom inputValues),
     perChunk perChunk,
     response (atom []),
     state (atom true),
     currentChunk (atom [])
     ]

    ; a border case fix
    (if (= (count @inputVector) 0)
      (reset! state false)
      )

    (while (= @state true)

      ; find the longest sequence in inputVector that less or equal to perChunk value
      ; and update currentChunk
      (reset! currentChunk (SearchData @inputVector perChunk))

      ; Add to response a new vector value, that contains values from inputVector from currentChunk[0] to currentChunk[1]
      (reset! response (conj @response (subvec @inputVector (get @currentChunk 0) (+ (get @currentChunk 1) 1))))

      ; remove currentChunk values from inputVector
      (reset! inputVector (into (subvec @inputVector 0 (get @currentChunk 0)) (subvec @inputVector (+ (get @currentChunk 1) 1))))

      (if (= (count @inputVector) 0)
        (reset! state false)
        )
      )

    @response
    )
  )

(println (init [64 64 128 32 16 8 16 32 128] 256))
