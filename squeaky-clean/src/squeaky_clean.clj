(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn capitalize-first-only
  "Capitalizes only the first character, leaving the rest unchanged"
  [s]
  (if (empty? s)
    s
    (str (str/upper-case (subs s 0 1))
         (subs s 1))))


(defn convert-kebab-case-to-camel-case
  "Converts kebab-case string to camelCase format"
  [s]
  (if (empty? s)
    s
    (let [parts (str/split s #"-")]
      (apply str (first parts)
             (map capitalize-first-only (rest parts))))))


;(defn clean
;  [s]
;  (-> s
;      (str/replace #" " "_")
;      (str/replace #"[\u0000-\u001F\u007F-\u009F]" "CTRL")
;      (convert-kebab-case-to-camel-case)
;      (str/replace #"[^\p{L}_]" "")  ; Use Unicode letter class instead
;      (str/replace #"[α-ω]" "")))

(defn clean
  [s]
  (-> s
      (str/replace #"\s" "_")
      (str/replace #"\p{Cc}" "CTRL")
      (str/replace #"-(\p{L})" #(str/upper-case (%1 1)))
      (str/replace #"[^\p{L}_]|[α-ω]" "")))

