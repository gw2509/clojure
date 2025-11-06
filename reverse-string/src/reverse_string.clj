(ns reverse-string)

;(defn reverse-string
;  "Reverses the given string"
;  [s]
;  (apply str (rseq (vec s))))

(defn reverse-string
  [s]
  (apply str (into '() s)))
