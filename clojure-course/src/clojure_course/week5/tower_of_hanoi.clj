(ns clojure-course.week5.tower-of-hanoi)

(defn move_disk
   [number_of_disks a b c]
  (when (> number_of_disks 0)
    (move_disk (dec number_of_disks) a c b)
    (println (format "disk%s moved %s -> %s" number_of_disks a b))
    (move_disk (dec number_of_disks) c b a)
    )
  )

(move_disk 3 "A" "B" "C")
