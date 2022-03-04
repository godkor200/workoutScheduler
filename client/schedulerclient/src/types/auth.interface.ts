interface AuthState {
  isLoading: boolean;
  isSignout: boolean;
  userToken: string | undefined | null;
}
interface AuthContextActions {
  signIn: (data: AuthSignInPayload) => Promise<string | undefined>;
  signUp: (data: AuthSignUpPayload) => Promise<string | undefined>;
  signOut: () => void;
}
interface AuthContextType extends AuthState, AuthContextActions {}

type AuthSignInPayload = { username: string; password: string };
type AuthSignUpPayload = {
  username: string;
  password: string;
  male: string;
  height: string;
  weight: string;
};

type AuthType = 'RESTORE_TOKEN' | 'SIGN_IN' | 'SIGN_OUT';
type Token = string | undefined | null;

export type {
  AuthContextType,
  AuthState,
  AuthContextActions,
  AuthSignInPayload,
  AuthSignUpPayload,
  AuthType,
  Token,
};
