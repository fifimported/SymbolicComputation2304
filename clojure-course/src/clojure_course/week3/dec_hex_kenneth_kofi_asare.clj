(ns clojure-course.week3.dec-hex-kenneth-kofi-asare)

(defn integer-to-hexadecimal [n]
  (format "%X" n))                                          ;;clojure function to perform conversion

(defn main []
  (print "Enter an integer: ")                              ;;prompts user to enter a number
  (flush)                                                   ;;enables output to be printed immediately
  (let [input (read-line)
        parsed-input (try (Integer/parseInt input)
                          (catch Exception e nil))]
    (if parsed-input                                        ;;if parsing is successful it executes the program
      (let [hex (integer-to-hexadecimal parsed-input)]      ;;converts the input into hexadecimal
        (println (str "Hexadecimal Representation is: " hex))))))

(main)

