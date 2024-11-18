/**
 * 필드명에서 언더바, 숫자, 괄호를 공백으로 변환하는 함수
 * @param name - 원본 필드명
 * @returns 포맷팅된 필드명
 * @example
 * formatFieldName("user_id123") // returns "user id"
 * formatFieldName("firstName2") // returns "firstName"
 * formatFieldName("data(test)") // returns "data test"
 */
export const formatFieldName = (name: string) => {
  return name
    .replace(/[_\d.a-zA-Z()[\]{}]/g, ' ')  // 언더바, 숫자, 괄호를 공백으로 변환
    .replace(/\s+/g, ' ')     // 연속된 공백을 하나로 통일
    .trim();                  // 앞뒤 공백 제거
};