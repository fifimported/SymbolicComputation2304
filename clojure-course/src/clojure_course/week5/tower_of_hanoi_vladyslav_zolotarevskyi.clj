(ns clojure-course.week5.tower-of-hanoi-vladyslav-zolotarevskyi)

(defn tower-of-hanoi
  [number_of_disks source auxiliary target]
  (if (<= number_of_disks 1)
    (println (str "Move disk " number_of_disks " from " source " to " target))
    (do
      (tower-of-hanoi (dec number_of_disks) source target auxiliary)
      (println (str "Move disk " number_of_disks " from " source " to " target))
      (tower-of-hanoi (dec number_of_disks) auxiliary source target))))

(defn hanoi
  [number_of_disks]
  (tower-of-hanoi number_of_disks "A" "C" "B" ))

(hanoi 3)
