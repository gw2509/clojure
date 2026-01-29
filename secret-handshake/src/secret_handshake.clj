(ns secret-handshake)

;(def actions {2r00001 "wink"
;              2r00010 "double blink"
;              2r00100 "close your eyes"
;              2r01000 "jump"})

;(defn commands [n]
;  (->> (take 4 (iterate (partial * 2) 1))
;       (map #(actions (bit-and n %)))
;       (filter identity)
;       (#(if (pos? (bit-and n 2r10000)) (reverse %) %))))


(def actions-2 ["wink"
                "double blink"
                "close your eyes"
                "jump"])

(defn commands [n]
  (->> (range (count actions-2))
       (filter (partial bit-test n))
       (map actions-2)
       (#(if (bit-test n 4) (reverse %) %))))
