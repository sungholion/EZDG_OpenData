import Link from "next/link";

export function AppFooter() {
  return (
    <footer className="w-full border-t mt-12">
      <div className="mx-auto w-full max-w-screen-xl p-4 md:py-6">
        <div className="sm:flex sm:items-center sm:justify-between">
          <span className="block text-sm text-gray-500 sm:text-center">
            © {new Date().getFullYear()} EZDG™. All Rights Reserved.
          </span>
          <ul className="mb-6 flex flex-wrap items-center text-sm font-medium text-gray-500 sm:mb-0">
            <li>
              <Link href="/" className="mr-4 hover:underline md:mr-6">
                Home
              </Link>
            </li>
            <li>
              <Link href="/" className="mr-4 hover:underline md:mr-6">
                Privacy Policy
              </Link>
            </li>
            <li>
              <Link href="/" className="mr-4 hover:underline md:mr-6">
                Licensing
              </Link>
            </li>
            <li>
              <Link href="/" className="hover:underline">
                Contact
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </footer>
  );
}
