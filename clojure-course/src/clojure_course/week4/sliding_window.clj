(ns clojure-course.week4.sliding_window)

(defn find_all_matches
  [input_vector max_value]
  (let [
        result (atom [])
        latest_index (- (count input_vector) 1)
        ]
    (loop [left_pos 0
           right_pos 1
           ]
      (println "left_pos=" left_pos "right_pos=" right_pos)
      (println "result=" @result )
      (let [
            current_window (subvec input_vector left_pos right_pos)
            current_window_sum (apply + current_window)
            window_suits #(<= current_window_sum max_value)
            finished #(or (= latest_index left_pos ) (= latest_index right_pos ))
            ]
          (println "current_window=" current_window "suits? >>" (window_suits))
          (when (window_suits)
            (when (> (count current_window) (count @result))
              (reset! result current_window)
              )
            )
          (if (finished)
            (do
              result)
            (if (window_suits)
              (recur (+ 0 left_pos) (inc right_pos))
              (recur (inc left_pos) (+ 0 right_pos))
              )
            )
          )
      )
    )
  )

(defn main []
  (let [
        inp_vect [3 2 1 3 1 1]
        max_val 5
        longest_vect (find_all_matches inp_vect max_val)
        ]
        (println "the longest vector=" @longest_vect)
    )
  )

(main)


