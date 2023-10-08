(ns clojure-course.week2.interview_task_1_anna_olexandra_danchenko)

(def vect [11 34 5 78 11 78 14 5 34])

;; Implementing a naive algorithm with complexity O(n^2)
(defn single-number [vect]
  (doseq [num vect]
    (if (= (count (filter #(= % num) vect)) 1)   ;; Filter function returns a new sequence of elements that satisfy the condition
      (println "The single number is" num))))

(single-number vect)

;; An algorithm using XOR (I am not gonna lie, I had to look the algorithm up)
(defn single-number-xor [vect]
  (let [res (atom (first vect))]
    (doseq [elem (rest vect)]
      (reset! res (bit-xor @res elem)))
    (println "The single number is" @res)))

(single-number-xor vect)

;; The idea behind the algorithm is that the same numbers will "cancel" each other out during the XOR operation and result into 0,
;; meanwhile 0 XOR number will result into the number itself. The best part is that the position of the elements doesn't matter.
;; The time complexity of the algorithm is O(n) and the space complexity is O(1)

;; Example: 101001 XOR 101001 = 000000, 000000 XOR 101001 = 101001

;; Here is the example of how the algorithm works in detail, with simple numbers.
(def simple-vect [1 1 2 2 3 3 4])
(defn single-number-xor-explanation [vect]
  (let [res (atom (first vect))]
    (doseq [elem (rest vect)]
      (println   "current-res" (Long/toString @res 2)
                 "elem" (Long/toString elem 2)
                 "bit-xor res" (Long/toString (bit-xor @res elem) 2))
      (reset! res (bit-xor @res elem)))
    (println "res" (Long/toString @res 2) @res)))

(single-number-xor-explanation simple-vect)
