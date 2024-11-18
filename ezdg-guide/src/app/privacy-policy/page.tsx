// app/privacy-policy/page.tsx
import { Card, CardContent } from "@/components/ui/card";

export default function PrivacyPolicyPage() {
  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl mb-8">개인정보 처리방침</h1>

      <div className="w-full grid grid-cols-1 gap-6">
        {/* 수집하는 개인정보 항목 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">1. 수집하는 개인정보 항목</h2>
            <div className="space-y-4">
              <div>
                <p className="text-gray-700 mb-2">EZDG는 추가 데이터 요청 시에만 다음의 개인정보를 수집합니다:</p>
                <ul className="list-disc pl-6 text-gray-600">
                  <li>이름</li>
                  <li>이메일 주소</li>
                  <li>소속 기관명</li>
                </ul>
              </div>
              <div>
                <p className="text-gray-700 mb-2">서비스 이용 과정에서 자동 수집되는 정보:</p>
                <ul className="list-disc pl-6 text-gray-600">
                  <li>IP 주소</li>
                  <li>서비스 이용 기록</li>
                  <li>API 호출 기록</li>
                </ul>
              </div>
            </div>
          </CardContent>
        </Card>

        {/* 수집 및 이용목적 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">2. 개인정보의 수집 및 이용목적</h2>
            <ul className="list-disc pl-6 text-gray-600 space-y-2">
              <li>추가 데이터 요청에 대한 처리 및 결과 회신</li>
              <li>서비스 이용 현황 파악 및 통계 분석</li>
              <li>서비스 개선 및 신규 서비스 개발</li>
              <li>기술적 문제 해결 및 보안 유지</li>
            </ul>
          </CardContent>
        </Card>

        {/* 보유 및 이용기간 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">3. 개인정보의 보유 및 이용기간</h2>
            <p className="text-gray-700 mb-4">
              수집된 개인정보는 데이터 요청 처리 완료 후 1년간 보관되며, 이후 즉시 파기됩니다.
            </p>
            <p className="text-gray-700 mb-2">다음의 경우에는 관련 법령에 따라 일정 기간 보관됩니다:</p>
            <ul className="list-disc pl-6 text-gray-600">
              <li>서비스 제공에 관한 기록: 3년 (전자상거래 등에서의 소비자보호에 관한 법률)</li>
              <li>웹사이트 방문기록: 3개월 (통신비밀보호법)</li>
            </ul>
          </CardContent>
        </Card>

        {/* 파기절차 및 방법 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">4. 개인정보의 파기절차 및 방법</h2>
            <p className="text-gray-700 mb-4">
              개인정보 보유기간이 경과하거나 처리목적이 달성된 경우, 해당 정보를 즉시 파기합니다.
            </p>
            <ul className="list-disc pl-6 text-gray-600">
              <li>전자적 파일 형태의 정보는 기술적 방법을 사용하여 안전하게 삭제</li>
              <li>기타 기록물은 파쇄 또는 소각</li>
            </ul>
          </CardContent>
        </Card>

        {/* 안전성 확보 조치 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">5. 개인정보의 안전성 확보 조치</h2>
            <ul className="list-disc pl-6 text-gray-600 space-y-2">
              <li>개인정보 암호화</li>
              <li>해킹 등에 대비한 보안시스템 구축</li>
              <li>개인정보에 대한 접근 권한 제한</li>
            </ul>
          </CardContent>
        </Card>

        {/* 이용자의 권리와 행사방법 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">6. 이용자의 권리와 그 행사방법</h2>
            <p className="text-gray-700">
              이용자는 언제든지 자신의 개인정보에 대한 열람, 정정, 삭제를 요청할 수 있습니다. 요청은 이메일을 통해
              가능하며, 지체 없이 처리해 드립니다.
            </p>
          </CardContent>
        </Card>

        {/* 개인정보 보호책임자 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">7. 개인정보 보호책임자</h2>
            <p className="text-gray-700">개인정보 보호책임자</p>
            <p className="text-gray-600 mt-2">이메일: tig04162@gmail.com</p>
          </CardContent>
        </Card>

        {/* 개인정보 처리방침의 변경 */}
        <Card className="bg-white">
          <CardContent className="p-6">
            <h2 className="text-xl font-semibold mb-4">8. 개인정보 처리방침의 변경</h2>
            <p className="text-gray-700 mb-4">
              이 개인정보 처리방침은 법령, 정책 또는 보안 기술의 변경에 따라 내용이 추가, 삭제 및 수정될 수 있습니다.
              변경사항이 발생하는 경우 웹사이트를 통하여 공지합니다.
            </p>
            <p className="text-gray-600">시행일자: 2024년 1월 1일</p>
          </CardContent>
        </Card>
      </div>
    </div>
  );
}
