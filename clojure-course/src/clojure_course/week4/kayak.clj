(ns clojure-course.week4.kayak)

; function that decides if the input argument is palindrome or not
(defn palindrome?
  [word]
  ; we define the main loop with 2 iterable variables
  ; each next iteration runs via recur function down below
  ; loop "[]" block can contain only iterable variables
  ; for other local variables there is "let" block
  ; here you can see the initial state of p1 and p2: the first and the last letters in the "word" argument
    (loop [p1 0
           p2 (-(count word) 1)
           ]
      ; on each iteration l1 and l2 get new values. They are letters on p1 and p2 indexes for "word"
      (let [l1 (get word p1)
            l2 (get word p2)
            ; this is a variable, yes, but it is not simply "true" or "false" -- it points on anonymous function (see # symbol)
            p_same? #(<= p2 p1)
            ; the same here -- points to function
            l_not_same? #(not= l1 l2)
            ]
        ; you may uncomment it to see debug info
        ;(println "p1=" p1 "p2=" p2)
        ;(println "l1=" l1 "l2=" l2)

        ; "if" can contain just one function for "true" and one function for "false"
        ; that the reason to use "do"
        ; as useful back effect, I can return true/false values. We need to return result of function, isn't?
        (if (p_same?)
          (do
            ; if p2 <= p1, means the whole word checked, all letters are the same
            ; the program checks letters in other branch
            ; this construct returns true and finish the function execution
              true
            )
          (do
            ; yes, here. Is l1 <> l2, this is definitely not a palindrome
            ; we should return false and exit
            (if (l_not_same?)
              (do
                false
                )
              ; this is important piece. It updates our loop's variables and... runs the loop again recursively
              (recur (inc p1) (dec p2))
              )
            )
          )
        )
      )
  )

(defn main []
  (let [
        result_of_func1 (palindrome? "kayak")
        result_of_func2 (palindrome? "karbak")
        ]
    (println "result_of_func1=" result_of_func1 "result_of_func2=" result_of_func2)
    )
  )

(main)
